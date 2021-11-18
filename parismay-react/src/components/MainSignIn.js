import React     from 'react';
import FormEntry from './FormEntry';

const MainSignIn = () => {
	return <main>
		<div className="main__entry entry">
			<h1 className="entry__title">Войти на сайт</h1>
			<FormEntry/>
			<hr className="hr-line"/>
			<div className="entry__social social">
				<h2 className="social__title">или</h2>
				<div className="social__icons">
					<div className="social__icon"></div>
					<div className="social__icon"></div>
					<div className="social__icon"></div>
					<div className="social__icon"></div>
				</div>
			</div>
		</div>
	</main>;
};

export default MainSignIn;