import '../styles/pageNotFound.css';

const PageNotFound = () => {
  return (
    <div className='wrap-center'>
      <div className="not-found-container">
      <h1 className="error-code">404</h1>
      <h2 className="error-message">Page Not Found</h2>
      <p className="error-description">
        Oops! The page you’re looking for doesn’t exist.
      </p>
      <a href="/" className="home-link">
        Go Back to Home
      </a>
    </div> 
    </div>
  );
};

export default PageNotFound;
