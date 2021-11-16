import * as React      from 'react';
import ReactDOM        from 'react-dom';
import {BrowserRouter} from 'react-router-dom';

import App from './App';

import '@utils/initMobX';

import '@styles/global.scss';

if (!localStorage.getItem('vkStatus')) localStorage.setItem('vkStatus', 'false');
if (!localStorage.getItem('instStatus')) localStorage.setItem('instStatus', 'false');
if (!localStorage.getItem('fbStatus')) localStorage.setItem('fbStatus', 'false');
if (!localStorage.getItem('twitterStatus')) localStorage.setItem('twitterStatus', 'false');

localStorage.setItem('vkToken', '69e5dbf77c667fc600fb96df76dc7f5ecae86c169be9a0ff85624fd883ad14a3c0ba5879a0e682674b281');

ReactDOM.render(
	<React.StrictMode>
		<BrowserRouter>
			<App/>
		</BrowserRouter>
	</React.StrictMode>,
	document.getElementById('root'),
);