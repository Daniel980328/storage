
import React from "react";
import { useParams } from "react-router-dom";
import { useSelector } from "react-redux";

function PostDetail() {
  const { id } = useParams();
  const post = useSelector((state) =>
    state.post.posts.find((post) => post.id === parseInt(id))
  );

  if (!post) {
    return <h2>게시글을 찾을 수 없습니다.</h2>;
  }

  return (
    <div>
      <h2>{post.title}</h2>
      <p>{post.content}</p>
    </div>
  );
}

export default PostDetail;
