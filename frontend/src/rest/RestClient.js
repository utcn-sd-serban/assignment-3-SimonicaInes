const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllQuestions() {
        return fetch(BASE_URL + "/questions", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createQuestion(title, question, author, date, tags) {
        return fetch(BASE_URL + "/questions", {
            method: "POST",
            body: JSON.stringify({
                title: title,
                question: question,
                author: author,
                date: date,
                tags: tags
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }
}