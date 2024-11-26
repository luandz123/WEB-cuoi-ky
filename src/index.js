import React from 'react';
import ReactDOM from 'react-dom/client';  // React 18 API
import './index.css';  // CSS của bạn, nếu có
import App from './App';  // Component chính của bạn
import 'bootstrap/dist/css/bootstrap.min.css';  // Import Bootstrap CSS
import reportWebVitals from './reportWebVitals';

// Khởi tạo và render ứng dụng React
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />  {/* Ứng dụng của bạn bắt đầu từ đây */}
  </React.StrictMode>
);

// Đo lường hiệu suất nếu bạn muốn, có thể bỏ qua nếu không cần
reportWebVitals();
