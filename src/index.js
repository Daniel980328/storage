import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux"; // Provider를 import
import store from "./store"; // store를 import
import App from "./App";

ReactDOM.render(
  <Provider store={store}> {/* Provider로 App을 감쌈 */}
    <App />
  </Provider>,
  document.getElementById("root")
);