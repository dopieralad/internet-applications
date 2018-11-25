import React from "react";
import ReactDOM from "react-dom";
import {MemoryRouter} from "react-router-dom";

import App from "../index";


describe("<App/>", () => {

    it("renders without crashing", () => {
        const div = document.createElement("div");

        ReactDOM.render(
            <MemoryRouter initialEntries={["/"]}>
                <App/>
            </MemoryRouter>,
            div
        );

        ReactDOM.unmountComponentAtNode(div);
    });
});
