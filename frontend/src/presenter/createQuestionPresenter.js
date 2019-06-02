import model from "../model/model";

class CreateQuestionPresenter {

    onCreate() {
        model.addQuestion(model.state.newQuestion.title, model.state.newQuestion.question,
            model.state.newQuestion.author, model.state.newQuestion.date, model.state.newQuestion.tags)
            .then(() => {
                model.changeNewQuestionProperty("title", "");
                model.changeNewQuestionProperty("question", "");
                model.changeNewQuestionProperty("author", "");
                model.changeNewQuestionProperty("date", "");
                model.changeNewQuestionProperty("tags", "");
                window.location.assign("#/");
            });
    }

    onChange(property, value) {
        model.changeNewQuestionProperty(property, value);
    }

}

const createQuestionPresenter = new CreateQuestionPresenter();

export default createQuestionPresenter;