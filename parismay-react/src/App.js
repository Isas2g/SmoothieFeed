import * as React from 'react';

import {
	BrowserRouter,
	Switch,
	Route,
	Redirect,
} from 'react-router-dom';

import Main             from '@pages/Main/Main';
import MainNews         from '@pages/MainNews';
import Auth             from '@pages/Auth/Auth';
import Programs         from '@pages/Programs';
import Achievements     from '@pages/Achievements';
import AboutApplication from '@pages/AboutApplication';

import {routes} from '@configs/routes';

const App = () => {
	const [detoxPrograms, setPrograms] = React.useState({
			easy: {
				time: 0,
				news: 0,
			},
			medium: {
				time: 0,
				news: 0,
			},
			hard: {
				time: 0,
				news: 0,
			},
		}),
		[reviews, setReviews] = React.useState([]);
	
	React.useEffect(() => {
		setPrograms({
			easy: {
				time: 60,
				news: 10,
			},
			medium: {
				time: 120,
				news: 30,
			},
			hard: {
				time: 240,
				news: 50,
			},
		});
		setReviews([
			{
				image: '#',
				username: 'Кузнецов Кирилл',
				date: '15.11.2021',
				review: 'Крутое приложение, советую всем друзьям! Крутое приложение, советую всем друзьям! Крутое приложение, советую всем друзьям! Крутое приложение, советую всем друзьям! Крутое приложение, советую всем друзьям! Крутое приложение, советую всем друзьям!',
				stars: 5,
			},
			{
				image: '#',
				username: 'Кузнецов Кирилл',
				date: '15.11.2021',
				review: 'Крутое приложение, советую всем друзьям!',
				stars: 2,
			},
			{
				image: '#',
				username: 'Кузнецов Кирилл',
				date: '15.11.2021',
				review: 'Крутое приложение, советую всем друзьям!',
				stars: 0,
			},
		]);
	}, []);
	
	return <BrowserRouter>
		<Switch>
			<Route exact path={routes.home.index}>
				<Main
					detoxPrograms={detoxPrograms}
					reviews={reviews}
				/>
			</Route>
			<Route exact path={routes.news.index}>
				<MainNews/>
			</Route>
			<Route exact path={routes.auth.index}>
				<Auth/>
			</Route>
			<Route exact path={routes.programs.index}>
				<Programs/>
			</Route>
			<Route exact path={routes.achievements.index}>
				<Achievements/>
			</Route>
			<Route exact path={routes.about.index}>
				<AboutApplication/>
			</Route>
			<Redirect to={routes.home.index}/>
		</Switch>
	</BrowserRouter>;
};

export default App;