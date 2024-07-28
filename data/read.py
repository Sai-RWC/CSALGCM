fpath = "almostsorted.txt"
output_file = open("almostsorted_num.txt", "w")
with open(fpath, 'r') as reader:
    line = reader.readline()
    while line != '':
        # print(line, end='')
        num = line.split(' ')[0]
        output_file.write(num+"\n")
        line = reader.readline()
