import React            from 'react';
import FormUserPrograms from './FormUserPrograms';
import DetoxPrograms    from './DetoxPrograms';

const MainPrograms = () => {
	return <main className="main">
		<div className="container-bg-image-social">
			<div className="container">
				<div className="main__programs programs">
					<h1 className="programs__title main-title">Выбрать существующую программу</h1>
					<DetoxPrograms/>
				</div>
			</div>
			<hr className="main__hr-line hr-line"/>
			<FormUserPrograms/>
		</div>
	</main>;
};

export default MainPrograms;