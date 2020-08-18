class radio:
    def __init__(self, sor):
        adatok = sor.rstrip().split(';')
        self.ora = int(adatok[0])
        self.perc = int(adatok[1])
        self.adasdb = int(adatok[2])
        self.nev = adatok[3]


lista = list()


def feladat2():
    with open('cb.txt', 'r') as file:
        elsosor = file.readline()
        for sor in file.readlines():
            lista.append(radio(sor))


def feladat3():
    print(f"3. feladat: Bejegyzések száma: {len(lista)} db")


def feladat4():
    volte = False
    for radio in lista:
        if radio.perc == 1 and radio.adasdb == 4:
            volte = True
            if volte is True:
                print(f"4. feladat: Volt négy adást indító sofőr.")
            if volte is False:
                print(f"4. feladat: Nem volt négy adást indító sofőr.")


def feladat5():
    bekertnev = input("5. feladat: Kérek egy nevet: ")
    db = 0
    for radio in lista:
        if radio.nev == bekertnev:
                db+=radio.adasdb
    print(f"{bekertnev} {db}x használta a CB-rádiót.")

def AtszamolPercre(ora,perc):
    return ora*60 + perc

def feladat7():
    with open('cb2.txt','w') as kimenet:
        kimenet.write("Kezdes;Nev,AdasDb\n")
        for radio in lista:
            kimenet.write(f"{AtszamolPercre(radio.ora,radio.perc)};{radio.nev};{radio.adasdb}\n")

def feladat8():
    for radio in lista:
        soforszam=len(set(radio.nev))
    print(f"8. feladat: Sofőrök száma: {soforszam} fő")

def main():
    feladat2()
    feladat3()
    feladat4()
    feladat5()
    feladat7()
    feladat8()

if __name__ == '__main__':
    main()
