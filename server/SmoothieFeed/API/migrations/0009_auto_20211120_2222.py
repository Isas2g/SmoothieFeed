# Generated by Django 3.2.9 on 2021-11-20 19:22

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('API', '0008_userusesocialmedia'),
    ]

    operations = [
        migrations.AlterUniqueTogether(
            name='userusesocialmedia',
            unique_together=set(),
        ),
        migrations.RemoveField(
            model_name='userusesocialmedia',
            name='public',
        ),
    ]
