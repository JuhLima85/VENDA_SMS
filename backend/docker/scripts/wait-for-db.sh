#!/bin/bash

set -e

host="$1"
port="$2"
shift 2
cmd="$@"

until mysql -h "$host" -P "$port" -uroot -proot -e "SELECT 1" > /dev/null 2>&1; do
  >&2 echo "Banco de dados não está pronto - aguardando..."
  sleep 1
done

>&2 echo "Banco de dados está pronto - executando o comando: $cmd"
exec $cmd

