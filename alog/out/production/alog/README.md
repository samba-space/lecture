## s7
### p9, p10
- 최단거리문제는 bfs로 푸는게 맞음 -> 최단거리에 도달하면 종료됨 -> dfs는 모든경로를 다 가봐야함, dfs는 제약이 있음(자식노드가 한쪽만 있으면 에러남, 즉 이진트리여야함)  
- 비가중치는 bfs, 가중치는 다익스트라로 푼다.  
### p12 (경로 탐색(dfs))
경로탐색에서 한번 방문한 노드는 방문하지 않음 -> check가 필요
### p14 그래프 최단거리
레벨 탐색으로 풀수도 있고, dis[nextVertex] = dis[curVertex] + 1 로도 풀수 있다.
요새는 레벨 탐색으로 푸는 문제도 많이 나온다.