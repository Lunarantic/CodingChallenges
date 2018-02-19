e function below.

def  wordparser(input_lines):
    """
    Given a set of lines, return the count of unique words and letters. A word is defined as any sequence of one or more lower-case letters (no numbers, no punctuation) where words are separated by white space

    Args:
        input_lines : list of lines from std intput to be parsed
        
    Returns:
        str : A string containing the following information:
            the count of words in the input
            the word "words"
            each unique word, and the count of times it occurs in the input (in alphabetical order, each on its own line)
            the word "letters"
            for every letter from a to z, the letter, and the count of times that letter occurred IN A WORD in the input
        
        Example output would be similar to the following:
            words
            test 1
            case 1
            letters
            a 1
            c 1
            e 2
            s 1
            t 2
            
         As a result string "words\ntest 1\ncase 1\nletters\na 1\nc 1\ne 2\ns 1\nt 2\n"
    """
    input_lines = [w for line in input_lines for w in line.split(' ')]
    out = ""
    out += str(len(input_lines)) + "\nwords"
    d = {}
    a = {}
    import string
    for c in string.ascii_lowercase:
        a[c] = 0
    for l in input_lines:
        s = False
        for c in l:
            if not c.isalpha():
                s = True
                break
        if s:
            break
        #l = l.lower()
        try:
            c = d[l]
        except:
            c = 0
        d[l] = c + 1
        for c in l:
            try:
                i = a[c]
                a[c] = i + 1
            except:
                pass
    for k, v in sorted(d.items()):
        out += "\n" + k + " " + str(v)
    out += "\nletters"
    for k, v in sorted(a.items()):
        out += "\n" + k + " " + str(v)
    out += "\n"
    return out
