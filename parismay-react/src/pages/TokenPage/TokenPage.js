import * as React from 'react';
import {useLocation, useHistory} from 'react-router-dom';

import './TokenPage.scss';

const TokenPage = (props) => {
	const location = useLocation();
	const history = useHistory();
	
	const params = React.useMemo(() => {
		return location.hash.split('&');
	}, [location.hash]);
	
	React.useEffect(() => {
		localStorage.setItem("vkToken", params[0].split('=')[1]);
		localStorage.setItem("vkTokenExpiresIn", params[1].split('=')[1]);
		localStorage.setItem("vkUserID", params[2].split('=')[1]);
		localStorage.setItem("vkStatus", "true");
		
		const timeout = setTimeout(() => history.push('/'), 5000);
		
		return () => clearTimeout(timeout);
	}, [history, params]);
	
	return <div className="token-page">
		Вы успешно авторизовались, эта страница скоро закроется.
	</div>
}

export default React.memo(TokenPage);