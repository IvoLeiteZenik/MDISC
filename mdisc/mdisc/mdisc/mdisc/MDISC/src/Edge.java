
    public class Edge {
        private Vertex vertexOrigin;
        private Vertex vertexDestination;
        private double distance;

        public Edge(Vertex vertexOrigin, Vertex vertexDestination, double distance) {
            this.vertexOrigin = vertexOrigin;
            this.vertexDestination = vertexDestination;
            this.distance = distance;
        }

        public Edge(Edge otherEdge){
            this.vertexOrigin = otherEdge.vertexOrigin;
            this.vertexDestination = otherEdge.vertexDestination;
            this.distance = otherEdge.distance;
        }

        public Vertex getVertexOrigin() {
            return vertexOrigin;
        }

        public Vertex getVertexDestination() {
            return vertexDestination;
        }

        public double getDistance() {
            return distance;
        }

        public void setVertexOrigin(Vertex vertexOrigin) {
            this.vertexOrigin = vertexOrigin;
        }

        public void setVertexDestination(Vertex vertexDestination) {
            this.vertexDestination = vertexDestination;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public String toString(){
            return String.format("Origin: %s ----- Destination: %s ----- Distance: %.2f", vertexOrigin, vertexDestination, distance);
        }

        public int compareTo(Edge otherEdge){
            return Double.compare(this.distance, otherEdge.distance);
        }


    }


