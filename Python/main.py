class tanulok:
    def __init__(self, sor):
        darabok = sor.split(';')
        self.nev = darabok[0]
        self.osztaly = darabok[1]
        self.elsonap = int(darabok[2])
        self.utolsonap = int(darabok[3])
        self.mulasztottorak = int(darabok[4])


lista = list()


def feladat1():
    with open('szeptember.csv', 'r') as file:
        elsosor = file.readline()
        for sor in file.readlines():
            lista.append(tanulok(sor))


def feladat2():
    mulasztottorak = 0
    for tanulok in lista:
        mulasztottorak += tanulok.mulasztottorak
    print(f"2. feladat \n Összes mulasztott órák száma: {mulasztottorak} óra.")


def feladat345():
    print("3.feladat")
    bekertnap = input("   Kérem adjon megy egy napot: ")
    bekerttanulo = input("    Tanuló neve: ")
    hianyzotte = False
    for tanulok in lista:
        if tanulok.nev == bekerttanulo:
            if tanulok.mulasztottorak > 0:
                hianyzotte = True
    print("4.feladat ")
    if hianyzotte == True:
        print(" A tanuló hiányzott szeptemberben")
    if hianyzotte == False:
        print(" A tanuló nem hiányzott szeptemberben")
    print(f"5.feladat: Hiányzók 2017.09.{bekertnap}-n:")
    for tanulok in lista:
        if tanulok.elsonap <= int(bekertnap) and tanulok.utolsonap >= int(bekertnap):
            print(f"{tanulok.nev} ({tanulok.osztaly})")
        if not (tanulok.elsonap <= int(bekertnap)) and not (tanulok.utolsonap >= int(bekertnap)):
            print("Nem volt hiányzó")


def main():
    feladat1()
    feladat2()
    feladat345()


if __name__ == '__main__':
    main()
