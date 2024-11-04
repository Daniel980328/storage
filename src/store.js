import { configureStore } from "@reduxjs/toolkit";
import PostSlice from "./slices/PostSlice";

const store = configureStore({
  reducer: {
    post: PostSlice
  },
});

export default store;
