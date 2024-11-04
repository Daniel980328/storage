import React from "react";
import PostItems from "./PostItems";
import { useSelector } from "react-redux";

function PostList() {
  const posts = useSelector((state) => state.post.posts);

  return (
    <>
      <h2>Post List</h2>
      <PostItems posts={posts} />
    </>
  );
}

export default PostList;
