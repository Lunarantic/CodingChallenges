import csv
from collections import Counter


def generateFiles(input_file):
    counter = {}
    cnt = 0
    averager = {}
    
    with open(input_file, 'r') as csvfile:
        reader = csv.reader(csvfile, delimiter=',')
        for row in reader:
            avg = None
            try:
                avg = averager[row[2]]
            except:
                avg = 0
        
            averager[row[2]] = avg + int(row[3])
            cnt += 1
            
            count = None
            try:
                count = counter[row[2]]
            except:
                count = Counter()
                counter[row[2]] = count
            counter[row[4]] += 1
            
    with open('0_%s' % input_file, 'w') as csvfile:
        writer = csv.writer(csvfile, delimiter=',')
        for k, v in averager.items():
            writer.writerow([k, float(v)/float(cnt)])
    
    with open('1_%s' % input_file, 'w') as csvfile:
        writer = csv.writer(csvfile, delimiter=',')
        for k, v in counter.items():
            writer.writerow([k, v.most_common(1)[0][0]])
    
    pass
