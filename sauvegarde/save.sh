#!/bin/bash

if pidof -o %PPID -x "$0"; then
        exit 1
fi

cd ~ || exit

# RClone Config file
RCLONE_CONFIG=/home/ubuntu/.config/rclone/rclone.conf
export RCLONE_CONFIG

title="save-$(date +'%Y-%m-%d').tar.gz"

tar -czvf "$title" /var/www/html/dokuwiki
/usr/bin/rclone copy "$title" gdrive:/devOps --log-file /home/ubuntu/save.log -vv
rm "$title"
