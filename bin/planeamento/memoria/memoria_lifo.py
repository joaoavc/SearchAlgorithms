from queue import LifoQueue
from memoria.memoria_procura import MemoriaProcura

class MemoriaLIFO(MemoriaProcura):
    
    def __init__(self):
        lifo_queue = LifoQueue()
        super().__init__(lifo_queue)
