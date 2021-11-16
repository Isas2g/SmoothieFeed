import * as React from 'react';

import {
	Switch,
	Route,
	Redirect,
	useLocation,
}                      from 'react-router-dom';
import {useLocalStore} from '@utils/hooks/useLocal';

import Main         from '@pages/Main/Main';
import News         from '@pages/News/News';
import Auth         from '@pages/Auth/Auth';
import Programs     from '@pages/Programs';
import Achievements from '@pages/Achievements';
import AboutUs      from '@pages/AboutUs/AboutUs';

import Header from '@components/Header';

import {routes} from '@configs/routes';

import MainStore from '@store/MainStore';

const App = () => {
	const mainStore = useLocalStore(() => new MainStore());
	
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
	
	const location = useLocation();
	
	return <div>
		{location?.pathname !== routes.auth.index && <Header/>}
		<Switch>
			<Route exact path={routes.home.index}>
				<Main
					detoxPrograms={detoxPrograms}
					reviews={reviews}
				/>
			</Route>
			<Route exact path={routes.news.index}>
				<News store={mainStore}/>
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
				<AboutUs/>
			</Route>
			<Redirect to={routes.home.index}/>
		</Switch>
	</div>;
};

export default App;