import { useState } from "react";
import { useDispatch } from "react-redux";
import { addPost } from "../slices/PostSlice";
import { useNavigate } from "react-router-dom";

function WritePost() {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    const newPost = { id: Date.now(), title, content };
    dispatch(addPost(newPost));
    setTitle("");
    setContent("");
    navigate("/posts"); // 작성 완료 후 게시글 목록으로 이동
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      /> <br/>
      <textarea
        placeholder="Content"
        value={content}
        onChange={(e) => setContent(e.target.value)}
      /><br/>
      <button type="submit">Add Post</button>
    </form>
  );
}

export default WritePost;
