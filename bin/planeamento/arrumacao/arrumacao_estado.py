import sys
sys.path.append("..")
from arvore import Estado
class ArrumacaoEstado(Estado):
     
     def __init__(self, x, y):
         '''
         Estado de arrumação automática

         Parameters
         ----------
         x :int
         y :int

         '''
         self.x = x
         self.y = y
         
     
     def __eq__(self, other):
         '''
         Comparação de objetos do tipo ArrumacaoEstado

         Parameters
         ----------
         other : type

         Returns
         -------
         TYPE :boolean

         '''
         #print(type(other))
         if not isinstance(other, ArrumacaoEstado):
          # print("Não compara tipos diferentes")
           return NotImplemented
         return (self.x == other.get_x()) and (self.y == other.get_y())
     
        
     def __hash__(self):
         '''
         Devolve um numero que permite identificar os diferentes
         objetos do tipo ArrumacaoEstado

         Returns
         -------
         TYPE: int

         '''
         return (self.x+1)*100 + self.y;
     
        
     def get_x(self):
         '''
         Devolve o x do ArrumacaoEstado

         Returns
         -------
         TYPE :int

         '''
         return self.x
        
        
     def get_y(self):
          '''
         Devolve o y do ArrumacaoEstado

         Returns
         -------
         TYPE :int

         '''
          return self.y