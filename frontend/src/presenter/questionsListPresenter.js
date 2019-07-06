import model from "../model/model";

class QuestionsListPresenter {
    onCreateQuestion() {
        window.location.assign("#/create-question");
    }

    onInit() {
        model.loadQuestions();
    }

    onFilterByTitleQuestion(){
        model.clearFilters();

        let iterator;
        for(iterator=0; iterator<model.state.questions.length; iterator++){
            if(model.state.questions[iterator].title===model.state.toFilter){
                model.addToFIlteredQuestions(
                    model.state.questions[iterator].authorId,
                    model.state.questions[iterator].title,
                    model.state.questions[iterator].text,
                    model.state.questions[iterator].tags,

                model.state.questions[iterator].date
                )
            }
        }
        // model.filterByTitle(model.state.toFilter);
        window.location.assign("#/filter-title-question");

    }

    swapToFilter(property,value){
        model.swapToFilter(property,value);
    }

    onFilterByTagQuestion() {
        model.clearFilters();

        let iterator;
        for (iterator = 0; iterator < model.state.questions.length; iterator++) {
            if (model.state.questions[iterator].tags === model.state.toFilter) {
                model.addToFIlteredQuestions(
                    model.state.questions[iterator].authorId,
                    model.state.questions[iterator].title,
                    model.state.questions[iterator].text,
                    model.state.questions[iterator].tags,

                    model.state.questions[iterator].date
                )
            }
        }
        // model.filterByTitle(model.state.toFilter);
        window.location.assign("#/filter-title-question");
    }
}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;