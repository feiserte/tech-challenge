import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Authentication from './Authentication';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<Authentication />, document.getElementById('root'));
registerServiceWorker();
