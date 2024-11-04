import { Outlet, NavLink} from "react-router-dom";
import React from "react";


function Header(){
    return(
        <>
    <h1>Home Page</h1>
      <NavLink to="/">Home</NavLink> | 
      <NavLink to="/posts">PostList</NavLink> | 
      <NavLink to="/posts/write">Write New Post</NavLink>
      <Outlet></Outlet>
      </>
    );
}
export default Header;