import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";
import WebSocketListener from "../ws/WebSocketListener";

const client = new RestClient("serban", "123");
const listener = new WebSocketListener("serban", "123");

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            questions: [],
            newQuestion: {
                title: "",
                question: "",
                author: "",
                date: "",
                tags: ""
            }
        };
    }

    loadQuestions() {
        return client.loadAllQuestions().then(questions => {
            this.state = { 
                ...this.state, 
                questions: questions
            };
            this.emit("change", this.state);
        })
    }

    addQuestion(title, question, author, date, tags) {
        return client.createQuestion(title, question, author, date, tags)
            .then(question => this.appendQuestion(question));
    }

    appendQuestion(question) {
        this.state = { 
            ...this.state, 
            questions: this.state.questions.concat([question])
        };
        this.emit("change", this.state);
    }

    changeNewQuestionProperty(property, value) {
        this.state = {
            ...this.state,
            newQuestion: {
                ...this.state.newQuestion,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }
}

const model = new Model();

listener.on("event", event => {
    if (event.type === "QUESTION_CREATED") {
        model.appendQuestion(event.question);
    }
});

export default model;