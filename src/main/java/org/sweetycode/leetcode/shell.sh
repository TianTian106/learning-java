# 192. Word Frequency
grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -nr | awk '{print $2,$1}'
tr -s ' ' '\n' < words.txt | sort | uniq -c | sort -nr | awk '{print $2,$1}'

# 193. Valid Phone Numbers
grep -P '^(\d{3}-|\(\d{3}\)\s)\d{3}-\d{4}$' file.txt
grep -E '^(([[:digit:]]{3}-)|(\([[:digit:]]{3}\)\s))[[:digit:]]{3}-[[:digit:]]{4}$' file.txt

# 194. Transpose File


# 195. Tenth Line
sed -n '10p' file.txt
tail -n +10 file.txt  | head -n 1
# If the first character of N (the number of bytes or lines) is a `+', print beginning with the Nth item from the start of each file, otherwise, print the last N items in the file.
cat file.txt|awk 'NR == 10'
