import * as React from 'react';
import {useLocation, useHistory} from 'react-router-dom';

import {routes} from '@configs/routes';

import './TokenPage.scss';

const TokenPage = () => {
	const location = useLocation();
	const history = useHistory();
	
	const params = React.useMemo(() => {
		return location.hash.split('&');
	}, [location.hash]);
	
	React.useEffect(() => {
		// localStorage.setItem("vkToken", params[0].split('=')[1]);
		localStorage.setItem("vkToken", "7bdd1738319e41db47f8ab378da8261d4e88c70bae47d3d7794a3a3476c9369fe73f7a86bab20ced20d8b");
		localStorage.setItem("vkTokenExpiresIn", params[1].split('=')[1]);
		localStorage.setItem("vkUserID", params[2].split('=')[1]);
		localStorage.setItem("vkStatus", "true");
		const timeout = setTimeout(() => history.push(routes.news.index), 5000);
		
		return () => clearTimeout(timeout);
	}, [history, params]);
	
	return <div className="token-page">
		Вы успешно авторизовались, эта страница скоро закроется.
	</div>
}

export default React.memo(TokenPage);