from datetime import timedelta
from django.contrib.auth.models import User
from django.db.models import Model, ForeignKey, IntegerField, DurationField, CASCADE


class UserSettings(Model):
    user = ForeignKey(User, on_delete=CASCADE)
    detox_limit_post = IntegerField(default=0)
    detox_limit_time = DurationField(default=timedelta(minutes=0))

    class Meta:
        db_table = 'user_settings'
        verbose_name = 'Пользовательская настройка'
        verbose_name_plural = 'Пользовательские настройки'
