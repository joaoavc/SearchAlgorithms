from queue import PriorityQueue
from memoria.memoria_procura import MemoriaProcura

class MemoriaPrioridade(MemoriaProcura):
    
    def __init__(self):
        prioridade_queue = PriorityQueue()
        super().__init__(prioridade_queue)