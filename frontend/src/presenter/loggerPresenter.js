import model from "../model/model";

class LoggerPresenter {



    onChange(property, value) {
        model.changeProperty(property, value);
    }

    login(){
        model.login();
        window.location.assign("#/questions");
    }

}

const loggerPresenter = new LoggerPresenter();

export default loggerPresenter;