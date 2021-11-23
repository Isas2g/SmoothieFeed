import React            from 'react';
import AchievementsList from "@components/AchievementsList/AchievementsList";

import "./Achievements.scss";

const Achievements = () => {
	return <main className="main">
		<div className="container">
			<div className="main__achievements achievements">
				<h1 className="achievements__title main-title">Достижения</h1>
				<AchievementsList/>
			</div>
		</div>
	</main>;
};

export default React.memo(Achievements);