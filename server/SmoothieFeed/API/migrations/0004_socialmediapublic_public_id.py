# Generated by Django 3.2.9 on 2021-11-08 21:57

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('API', '0003_remove_socialmediapublic_name'),
    ]

    operations = [
        migrations.AddField(
            model_name='socialmediapublic',
            name='public_id',
            field=models.IntegerField(default=1, unique=True),
            preserve_default=False,
        ),
    ]
