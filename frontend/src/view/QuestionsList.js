import React from "react";

const QuestionsList = ({ questions, title, onCreateQuestion,onFilterByTitleQuestion,
                           onFilterByTagQuestion, swapToFilter }) => (
    <div>
        <h2>{ title || "Questions" }</h2>
        <table border="1">
            <thead>
            <tr>
                <th>Author Id</th>
                <th>Title</th>
                <th>Text</th>
                <th>Tags</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            {
                questions.map((question, index) => (
                    <tr key={index} data-cy="question">
                        <td>{question.authorId}</td>
                        <td>{question.title}</td>
                        <td>{question.text}</td>
                        <td>{question.tags}</td>
                        <td>{question.date}</td>
                    </tr>
                ))
            }
            </tbody>
        </table>
        <button onClick={onCreateQuestion} data-cy="add">Add new Question</button>
        <input onChange={ e => swapToFilter("toFilter", e.target.value) } />

        <button onClick={onFilterByTitleQuestion}> Filter By Title</button>
        <br/>
        <br/>
        <input onChange={e => swapToFilter("toFilter", e.target.value)}/>
        <button onClick={onFilterByTagQuestion}> Filter By Tag</button>
    </div>
);

export default QuestionsList;