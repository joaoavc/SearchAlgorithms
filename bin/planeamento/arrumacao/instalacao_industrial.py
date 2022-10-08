from arrumacao.arrumacao_estado import *

class InstalacaoIndustrial:
    
    def __init__(self, path_ficheiro):
        '''
        Representação da instalação industrial

        Parameters
        ----------
        path_ficheiro :str

        '''
        self.estado_inicial = None
        self.estado_final = None
        self.instalacao_industrial = []
        self.coords = []
        self.ficheiro = open(path_ficheiro, "r")
        self.representacao_amabiente()
        self.define_estados()
        
        
    def representacao_amabiente(self):
        '''
        Representação do ambiente em listas, e obtenção de coordenadas
        '''
        for line in self.ficheiro:
            if(line == " " + '\n'):
                continue
            if(line[0] == 'O'):
                 linha = []
                 for simbolo in line:
                     if(simbolo == '\n'):
                         continue
                     linha.append(simbolo)
                 self.instalacao_industrial.append(linha)
                 print(len(linha))
            else:
                num = ""
                for digito in line:
                    if(digito != "" and digito != '\n'):
                        num = num + digito
                self.coords.append(num)
        
        print(len(self.instalacao_industrial))
      
        
        
    def define_estados(self):
        '''
        Definição do estado inicial e estado final
 
        '''
        inicio_x = int(self.coords[0])
        inicio_y = int(self.coords[1])
        final_x  = int(self.coords[2])
        final_y  = int(self.coords[3])
        self.estado_inicial = ArrumacaoEstado(inicio_x, inicio_y)
        self.estado_final = ArrumacaoEstado(final_x, final_y)
        
        
    def get_estado_inicial(self):
        '''
        Devolve o estado inicial do planeamento

        Returns
        -------
        TYPE: ArrumacaoEstado

        '''
        return self.estado_inicial
    
    
    def get_estado_final(self):
        '''
        Devolve o estado final do planeamento

        Returns
        -------
        TYPE: ArrumacaoEstado

        '''
        return self.estado_final
        
    
    def posicao_obstaculo(self, x, y):
        '''
        Verifica se a posição fornecida é um obsaculo

        Parameters
        ----------
        x : int
        y : int
            DESCRIPTION.
        '''
        if(self.instalacao_industrial [y][x] == 'O'): return True
        else: return False