import React from "react";

const QuestionsList = ({ questions, title, onCreateQuestion }) => (
    <div>
        <h2>{ title || "Questions" }</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Question</th>
                    <th>Author</th>
                    <th>Date</th>
                    <th>Tags</th>
                </tr>
            </thead>
            <tbody>
                {
                    questions.map((question, index) => (
                        <tr key={index} data-cy="question">
                            <td>{question.title}</td>
                            <td>{question.question}</td>
                            <td>{question.author}</td>
                            <td>{question.date}</td>
                            <td>{question.tags}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <button onClick={onCreateQuestion} data-cy="add">Add new Question</button>
    </div>
);

export default QuestionsList;