
import React, { useState, useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useParams, useNavigate } from "react-router-dom";
import { editPost } from "../slices/PostSlice";


function EditPost() {
  const { id } = useParams();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const post = useSelector((state) =>
    state.post.posts.find((post) => post.id === parseInt(id))
  );

  const [title, setTitle] = useState(post ? post.title : "");
  const [content, setContent] = useState(post ? post.content : "");

  useEffect(() => {
    if (!post) {
      alert("해당 게시글을 찾을 수 없습니다.");
      navigate("/posts"); // 게시글이 없으면 목록으로 이동
    }
  }, [post, navigate]);

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(editPost({ id: parseInt(id), title, content }));
    navigate("/posts"); // 수정 후 게시글 목록으로 이동
  };

  return (
    <div>
      <h2>게시글 수정</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        /> <br/>
        <textarea
          placeholder="contents"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        /> <br/>
        <button type="submit">수정하기</button>
      </form>
    </div>
  );
}

export default EditPost;
