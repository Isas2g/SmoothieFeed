import * as React       from 'react';
import HeaderEntry from '@components/HeaderEntry';
import MainSignIn  from '@components/MainSignIn';

const Auth = () => {
	return <div className="container-bg-image-social">
		<HeaderEntry/>
		<MainSignIn/>
	</div>;
};

export default Auth;