import model from "../model/model";

class CreateQuestionPresenter {

    onCreate() {
        model.addQuestion(model.state.newQuestion.authorId, model.state.newQuestion.title, model.state.newQuestion.text,model.state.newQuestion.tags, model.state.newQuestion.date)
            .then(() => {
                model.changeNewQuestionProperty("authorId", "");
                model.changeNewQuestionProperty("title", "");
                model.changeNewQuestionProperty("text", "");
                model.changeNewQuestionProperty("tags", "");
                model.changeNewQuestionProperty("date", "");
                window.location.assign("#/questions");
            });
    }

    onChange(property, value) {
        model.changeNewQuestionProperty(property, value);
    }

}

const createQuestionPresenter = new CreateQuestionPresenter();

export default createQuestionPresenter;