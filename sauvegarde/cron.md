Cron expression to trigger save.sh

The script compress and copy the dokuwiki in google drive
The output is saved in saveWiki.log file

```
# Under ubuntu user
crontab -e
00 21   * * *   /bin/bash /home/ubuntu/save.sh > /home/ubuntu/saveWiki.log
```

Every day at 21:00