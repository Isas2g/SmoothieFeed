import * as React from 'react';

import {
	BrowserRouter,
	Switch,
	Route,
	Redirect
} from 'react-router-dom';

import MainNews         from '@pages/MainNews';
import Main             from '@pages/Main';
import Entry            from '@pages/Entry';
import Programs         from '@pages/Programs';
import Achievements     from '@pages/Achievements';
import AboutApplication from '@pages/AboutApplication';

import '@styles/App.scss';
import '@styles/nullStyle.scss';

const App = () => {
	return <BrowserRouter>
		<Switch>
			<Route exact path="/">
				<Main/>
			</Route>
			<Route exact path="/news">
				<MainNews/>
			</Route>
			<Route exact path="/entry">
				<Entry/>
			</Route>
			<Route exact path="/programs">
				<Programs/>
			</Route>
			<Route exact path="/achievements">
				<Achievements/>
			</Route>
			<Route exact path="/about">
				<AboutApplication/>
			</Route>
			<Redirect to="/"/>
		</Switch>
	</BrowserRouter>;
};

export default App;