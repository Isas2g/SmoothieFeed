from datetime import timedelta

from django.db.models import Model, CharField, IntegerField, DurationField


class DetoxLevel(Model):
    level = IntegerField(
        unique=True,
        verbose_name='уровень'
    )
    name = CharField(
        max_length=64,
        unique=True,
        verbose_name='название'
    )
    post = IntegerField(
        default=0,
        verbose_name='посты')
    time = DurationField(
        default=timedelta(minutes=0),
        verbose_name='время')

    class Meta:
        db_table = 'API_detox_level'
        verbose_name = 'Уровень детокса'
        verbose_name_plural = 'Уровни детокса'

    def __str__(self):
        return f'{self.level}: {self.name}'
