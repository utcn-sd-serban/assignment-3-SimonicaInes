import model from "../model/model";

class QuestionsListPresenter {
    onCreateQuestion() {
        window.location.assign("#/create-question");
    }

    onInit() {
        model.loadQuestions();
    }
}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;