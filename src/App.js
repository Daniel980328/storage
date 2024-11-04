import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './components/Homepage';
import PostList from './components/PostList';
import WritePost from './components/WritePost';
import EditPost from './components/EditPost';
import PostDetail from './components/PostDetails'; 

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/posts" element={<PostList />} />
        <Route path="/posts/write" element={<WritePost />} />
        <Route path="/posts/:id/edit" element={<EditPost />} />
        <Route path="/posts/:id" element={<PostDetail />} /> {/* 게시글 상세 */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
