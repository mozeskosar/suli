import datetime

class auto:
    def __init__(self, sor):
        darabok = sor.rstrip().split(' ')
        ido = darabok[1].split(':')
        self.nap = int(darabok[0])
        self.ido = datetime.time(hour=int(ido[0]), minute=int(ido[1]))
        self.rendszam = darabok[2]
        self.szemelyazon = int(darabok[3])
        self.kmszamlalo = int(darabok[4])
        self.kibe = darabok[5] == '1'

    def __str__(self):
        return f"{self.ido.hour}:{self.ido.minute} {self.rendszam} {self.szemelyazon} {'be' if self.kibe else 'ki'}"

lista = list()

def feladat1():
    with open('autok.txt', 'r') as file:
        for sor in file.readlines():
            lista.append(auto(sor))


def feladat2():
    print("2.feladat")
    for auto in reversed(lista):
        if not auto.kibe:

            print(f"{auto.nap}. nap rendszám: {auto.rendszam}")
            break

def feladat3():
    print("3. feladat")
    nap = int(input("Nap: "))
    for auto in lista:
        if auto.nap == nap:
            print(auto)

def feladat4():
    print("4. feladat")
    kocsik =dict()  #rendszam - garazsban van-e
    for auto in lista:
        kocsik[auto.rendszam] = auto.kibe
    print("A hónap végén {0} autót nem hoztak vissza.".format(list(kocsik.values()).count(False)))

def feladat5():
    print("5. feladat")
    kocsik=dict() #rendszam -tuple(utolso km, megtett km)
    for auto in lista:
        if auto.rendszam in kocsik:
           mostment = auto.kmszamlalo - kocsik[auto.rendszam][0]
           eddigment= kocsik[auto.rendszam][1]+mostment
           kocsik[auto.rendszam] = (auto.kmszamlalo,eddigment)
        else:
            kocsik[auto.rendszam] = (auto.kmszamlalo,0)
    for rendszam,adatok in kocsik.items():
        print(f"{rendszam} {adatok[1]} km")

def feladat6():
    print("6. feladat")
    kocsik = dict() #rendszam-utolso km
    maxkm=0
    maxszemely=0
    for auto in lista:
        if  auto.rendszam in kocsik:
            mostment= auto.kmszamlalo - kocsik[auto.rendszam]
            kocsik[auto.rendszam] = auto.kmszamlalo
            if mostment > maxkm:
                maxkm = mostment
                maxszemely = auto.szemelyazon
        else:
            kocsik[auto.rendszam] = auto.kmszamlalo
    print(f"Leghosszabb út: {maxkm} km, személy: {maxszemely}")

def feladat7():
    print("7. feladat")
    rendszam=input("Rendszám: ")
    with open(f'{rendszam}_menetlevel.txt','w') as file:
     for auto in lista:
        if auto.rendszam != rendszam:
            continue
        if auto.kibe:
            file.write("{0}.\t{1}:{2}\t{3} km\n"
                       .format(auto.nap,auto.ido.hour,auto.ido.minute,auto.kmszamlalo))
        else:
            file.write(f'{auto.szemelyazon}\t{auto.nap}.\t{auto.ido.hour}:{auto.ido.minute}\t{auto.kmszamlalo} km\t')

    print("Menetlevél kész.")

def main():
    feladat1()
    feladat2()
    feladat3()
    feladat4()
    feladat5()
    feladat6()
    feladat7()

if __name__ == '__main__':
    main()
