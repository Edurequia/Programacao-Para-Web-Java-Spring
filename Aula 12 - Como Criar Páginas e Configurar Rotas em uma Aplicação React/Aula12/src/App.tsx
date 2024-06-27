import { Link } from 'react-router-dom';
import AppRoutes from './routes';

function App() {
  return (
    <div>
      <Link to="/">Home</Link> | <Link to="/about">About</Link>
      <AppRoutes />
    </div>
  );
}

export default App;