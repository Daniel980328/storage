import React from "react";
import { useDispatch } from "react-redux";
import { NavLink } from "react-router-dom";
import { deletePost } from "../slices/PostSlice";

function PostItems({ posts }) { // posts를 props로 받음
  const dispatch = useDispatch();

  const handleDelete = (id) => {
    console.log("handleDelete id", id);
    dispatch(deletePost(id));
  };

  return (
    <div>
      <ul>
        {posts.map((post) => (
          <li key={post.id}>
            <NavLink to={`/posts/${post.id}`}>{post.title}</NavLink>
            &nbsp;
            <button onClick={() => handleDelete(post.id)}>Delete</button>
            &nbsp;
            <NavLink to={`/posts/${post.id}/edit`}>Edit</NavLink>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PostItems;
