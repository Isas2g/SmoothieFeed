from datetime import timedelta

from django.contrib.auth.models import User
from django.db.models import Model, ForeignKey, IntegerField, DateTimeField, DurationField, CASCADE


class UserSources(Model):
    user = ForeignKey(User, on_delete=CASCADE)
    last_seen = DateTimeField(auto_now=True)
    total_seen_post = IntegerField(default=0)
    total_seen_time = DurationField(default=timedelta(minutes=0))

    class Meta:
        db_table = 'API_user_sources'
