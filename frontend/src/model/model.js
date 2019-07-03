import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";
import WebSocketListener from "../ws/WebSocketListener";


const listener = new WebSocketListener("serban", "password");

class Model extends EventEmitter {
    constructor() {
        super();
        this.question = new RestClient();
        this.state = {
            questions: [],
            newQuestion: {
                authorId: "",
                title: "",
                text: "",
                tags: "",
                date: ""
            },
            filteredQuestions: [{
                title: "",
                question: "",
                author: "",
                date: "",
                tags: ""
            }],

            toFilter:"Kittens",

            username:"",
            password:""


        };
    }

    login(){
        this.question = new RestClient(this.state.username,this.state.password);
    }




    loadQuestions() {
        return this.question.loadAllQuestions().then(questions => {
            this.state = { 
                ...this.state,
                questions: questions
            };
            this.emit("change", this.state);
        })
    }

    addQuestion(authorId, title, text, tags, date) {
        return this.question.createQuestion(authorId, title, text, tags, date)
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

    changeProperty(property, value) {
        this.state = {
            ...this.state,
            [property]: value
        };
        this.emit("change", this.state);
    }

    swapToFilter(property, value){
        this.state={
            ...this.state,
            [property]:value
        };
        this.emit("change", this.state);
    }
    addToFIlteredQuestions(title, question, author, date, tags){
        this.state = {
            ...this.state,
            filteredQuestions: this.state.filteredQuestions.concat([{
                title: title,
                question: question,
                author: author,
                date: date,
                tags: tags
            }])
        };
    }
    clearFilters(){
        this.state = {
            ...this.state,
            filteredQuestions: []
        };
    }



}

const model = new Model();

listener.on("event", event => {
    if (event.type === "QUESTION_CREATED") {
        model.appendQuestion(event.question);
    }
});

export default model;